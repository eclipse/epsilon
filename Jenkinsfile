pipeline {
    agent {
      kubernetes {
        label 'ui-test'
      }
    }
    environment {
      KEYRING = credentials('secret-subkeys.asc')
    }
    tools {
        maven 'apache-maven-3.5.4'
        jdk 'oracle-jdk8-latest'
    }
    triggers {
        pollSCM('H/5 * * * *')
    }
    stages {
        stage('Build') {
          steps {
            slackSend (channel: '#ci-notifications', botUser: true, color: '#FFFF00', message: "STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
            wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
              sh 'mvn -B --quiet clean install javadoc:aggregate'
            }
            sh 'cd standalone/org.eclipse.epsilon.standalone/ && bash build-javadoc-jar.sh'
		    lock('download-area') {
		      sshagent (['projects-storage.eclipse.org-bot-ssh']) {
			    sh '''
				  ssh genie.epsilon@projects-storage.eclipse.org 'cd /home/data/httpd/download.eclipse.org/epsilon/interim && for jar in $(ls features/*.jar | xargs -n 1 basename); do curl -o features-signed/$jar -F file=@features/$jar http://build.eclipse.org:31338/sign ; done && rm -rf features/*.jar; mv features-signed features && rm -rf features-signed; for jar in $(ls plugins/*.jar | xargs -n 1 basename); do curl -o plugins-signed/$jar -F file=@plugins/$jar http://build.eclipse.org:31338/sign ; done && rm -rf plugins/*.jar; mv plugins-signed plugins && rm -rf plugins-signed;'
				'''
		      }
		    }
          }
        }
        stage('Update website') {
          when { branch 'master' }
          steps {
            lock('download-area') {
              sshagent (['projects-storage.eclipse.org-bot-ssh']) {
                sh '''
                  ssh genie.epsilon@projects-storage.eclipse.org rm -rf /home/data/httpd/download.eclipse.org/epsilon/interim
                  scp -r "$WORKSPACE/releng/org.eclipse.epsilon.updatesite.interim/target/site" genie.epsilon@projects-storage.eclipse.org:/home/data/httpd/download.eclipse.org/epsilon/interim
                  scp "$WORKSPACE/releng/org.eclipse.epsilon.updatesite.interim/target/site_assembly.zip" genie.epsilon@projects-storage.eclipse.org:/home/data/httpd/download.eclipse.org/epsilon/interim/site.zip
                  ssh genie.epsilon@projects-storage.eclipse.org rm -rf /home/data/httpd/download.eclipse.org/epsilon/interim-*
				  ssh genie.epsilon@projects-storage.eclipse.org mkdir -p /home/data/httpd/download.eclipse.org/epsilon/interim-jars
                  scp "$WORKSPACE"/standalone/org.eclipse.epsilon.standalone/target/epsilon-* genie.epsilon@projects-storage.eclipse.org:/home/data/httpd/download.eclipse.org/epsilon/interim-jars/
                  #ssh genie.epsilon@projects-storage.eclipse.org 'cd /home/data/httpd/download.eclipse.org/epsilon && for jar in $(ls interim-jars-unsigned/*.jar | xargs -n 1 basename); do curl -o interim-jars/$jar -F file=@interim-jars-unsigned/$jar http://build.eclipse.org:31338/sign ; done; rm -rf /home/data/httpd/download.eclipse.org/epsilon/interim-jars-unsigned'
                  scp -r "$WORKSPACE/target/site/apidocs" genie.epsilon@projects-storage.eclipse.org:/home/data/httpd/download.eclipse.org/epsilon/interim-javadoc
                '''
              }
            }
          }
        }
        stage('Deploy to OSSRH') {
          when { branch 'master' }
          steps {
            sh '''
gpg --batch --import "${KEYRING}"
for fpr in $(gpg --list-keys --with-colons  | awk -F: '/fpr:/ {print $10}' | sort -u);
do
  echo -e "5\ny\n" |  gpg --batch --command-fd 0 --expert --edit-key $fpr trust;
done
            '''
            lock('ossrh') {
              sh 'mvn -B --quiet -f standalone/org.eclipse.epsilon.standalone/pom.xml -P ossrh org.eclipse.epsilon:eutils-maven-plugin:deploy'
            }
          }
        }
    }
    post {
      /*always {
        emailext (body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
                recipientProviders: [[
                   $class: "DevelopersRecipientProvider",
                   $class: "RequesterRecipientProvider"
                ]],
            subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}",
			to: "epsilon-dev@eclipse.org"
		)
      }*/
      success {
        slackSend (channel: '#ci-notifications', botUser: true, color: '#00FF00', message: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
      }
      failure {
        slackSend (channel: '#ci-notifications', botUser: true, color: '#FF0000', message: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
		
		mail to: 'epsilon-dev@eclipse.org',
		  subject: 'Epsilon Interim build failed!',
		  body: "Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}. More info at ${env.BUILD_URL}",
          charset: 'UTF-8',
          mimeType: 'text/html'
      }
    }
}
