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
    stages {
        stage('Build') {
            steps {
                wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
                  sh 'mvn -B clean install javadoc:aggregate'
                }
                sh 'cd standalone/org.eclipse.epsilon.standalone/ && bash build-javadoc-jar.sh'
            }
        }
        stage('Update website') {
          steps {
            sshagent ( ['projects-storage.eclipse.org-bot-ssh']) {
              sh '''
                ssh genie.epsilon@projects-storage.eclipse.org rm -rf /home/data/httpd/download.eclipse.org/epsilon/interim
                scp -r "$WORKSPACE/releng/org.eclipse.epsilon.updatesite.interim/target/site" genie.epsilon@projects-storage.eclipse.org:/home/data/httpd/download.eclipse.org/epsilon/interim
                scp "$WORKSPACE/releng/org.eclipse.epsilon.updatesite.interim/target/site_assembly.zip" genie.epsilon@projects-storage.eclipse.org:/home/data/httpd/download.eclipse.org/epsilon/interim/site.zip
                ssh genie.epsilon@projects-storage.eclipse.org bash -c "rm -rf /home/data/httpd/download.eclipse.org/epsilon/interim-jars/*"
                scp "$WORKSPACE/standalone/org.eclipse.epsilon.standalone/target/epsilon-"* /home/data/httpd/download.eclipse.org/epsilon/interim-jars
                ssh genie.epsilon@projects-storage.eclipse.org rm -rf /home/data/httpd/download.eclipse.org/epsilon/interim-javadoc
                scp -r "$WORKSPACE/target/site/apidocs" genie.epsilon@projects-storage.eclipse.org:/home/data/httpd/download.eclipse.org/epsilon/interim-javadoc
              '''
            }
          }
        }
        stage('Deploy to OSSRH') {
          steps {
            withMaven(maven: 'apache-maven-3.3.9', mavenSettingsFilePath: '/opt/public/hipp/homes/genie.epsilon/.m2/settings-deploy-ossrh.xml') {
              sh '''
gpg --batch --import "${KEYRING}"
for fpr in $(gpg --list-keys --with-colons  | awk -F: '/fpr:/ {print $10}' | sort -u);
do
  echo -e "5\ny\n" |  gpg --batch --command-fd 0 --expert --edit-key $fpr trust;
done
              '''
              sh 'mvn -B -f standalone/org.eclipse.epsilon.standalone/pom.xml -P ossrh org.eclipse.epsilon:eutils-maven-plugin:deploy'
            }
          }
        }
    }
}
