@NonCPS
def getSlackMessage() {
    MAX_MSG_LEN = 100

    def message = "Build <${env.BUILD_URL}|#${env.BUILD_NUMBER}> of <https://git.eclipse.org/c/epsilon/org.eclipse.epsilon.git/log/?h=${env.BRANCH_NAME}|${currentBuild.fullProjectName}> "
    message += currentBuild.currentResult == "SUCCESS" ? "passed\n\n" : "failed\n\n"

    for (changeSet in currentBuild.changeSets) {
      for (entry in changeSet.items) {
        message += "`${entry.commitId.take(7)}` ${entry.msg} - ${entry.author}\n"
      }
    }

    return message
}

pipeline {
    agent {
      kubernetes {
        label 'ui-test'
      }
    }
    options {
      disableConcurrentBuilds()
      buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '28', numToKeepStr: ''))
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
          when { allOf { branch 'master'; changeset comparator: 'REGEXP', pattern: '(Jenkinsfile)|(features\\/.*)|(plugins\\/.*)|(tests\\/.*)|(releng\\/.*)|(pom\\.xml)|(standalone\\/.*)' } }
          steps {
            wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: false]) {
              sh 'mvn -B --quiet clean install -P eclipse-sign javadoc:aggregate'
            }
            sh 'cd standalone/org.eclipse.epsilon.standalone/ && bash build-javadoc-jar.sh'
          }
        }
        stage('Update website') {
          when { allOf { branch 'master'; not { changeset 'examples/**' } } }
          steps {
            lock('download-area') {
              sshagent (['projects-storage.eclipse.org-bot-ssh']) {
                sh '''
                  INTERIMWS="$WORKSPACE/releng/org.eclipse.epsilon.updatesite.interim"
                  SITEDIR="$INTERIMWS/target"
                  if [ -d "$SITEDIR" ]; then
                    INTERIM=/home/data/httpd/download.eclipse.org/epsilon/interim
                    UPDATES=$INTERIM/updates
                    ssh genie.epsilon@projects-storage.eclipse.org "rm -rf $UPDATES; rm -rf $INTERIM/javadoc; mkdir -p $INTERIM/jars"
                    declare -a INTERIMFILES=("compositeArtifacts.xml" "compositeContent.xml" "associateSites.xml")
                    for F in "${INTERIMFILES[@]}"; do
                      if [ -e "$INTERIMWS/$F" ]; then
                        scp "$INTERIMWS/$F" genie.epsilon@projects-storage.eclipse.org:${INTERIM}/${F}
                      fi
                    done
                    scp -r "$SITEDIR/site" genie.epsilon@projects-storage.eclipse.org:${UPDATES}
                    scp "$SITEDIR/site_assembly.zip" genie.epsilon@projects-storage.eclipse.org:${UPDATES}/site.zip
                    scp "$WORKSPACE"/standalone/org.eclipse.epsilon.standalone/target/epsilon-* genie.epsilon@projects-storage.eclipse.org:${INTERIM}/jars
                    scp -r "$WORKSPACE/target/site/apidocs" genie.epsilon@projects-storage.eclipse.org:${INTERIM}/javadoc
                  fi
                '''
              }
            }
          }
        }
        /*stage('Sign JARs') {  // See pom.xml - done by Tycho
          when { allOf { branch 'master'; changeset comparator: 'REGEXP', pattern: '(features.*)|(plugins.*)' } }
          steps {
            lock('download-area') {
              sshagent (['projects-storage.eclipse.org-bot-ssh']) {
                sh '''
                  ssh genie.epsilon@projects-storage.eclipse.org 'cd /home/data/httpd/download.eclipse.org/epsilon/interim && declare -a folders=("features" "plugins"); for folder in "${folders[@]}"; do cd $folder && for jar in $(ls *.jar); do echo "Signing ${jar}..." && curl --create-dirs -o "signed/$jar" -F "file=@$jar" http://build.eclipse.org:31338/sign; done && mv -f signed/* . && rm -r signed && cd ../; done;'
                '''
              }
            }
          }
        }*/
        stage('Deploy to OSSRH') {
          when { allOf { branch 'master'; changeset comparator: 'REGEXP', pattern: '(features\\/.*)|(plugins\\/.*)|(standalone\\/.*)' } }
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
      success {
        slackSend (channel: '#ci-notifications', botUser: true, color: '#00FF00', message: getSlackMessage())
      }
      failure {
        slackSend (channel: '#ci-notifications', botUser: true, color: '#FF0000', message: getSlackMessage())
        mail to: 'epsilon-dev@eclipse.org',
        subject: 'Epsilon Interim build failed!',
        body: "${env.BUILD_TAG}. More info at ${env.BUILD_URL}",
        charset: 'UTF-8',
        mimeType: 'text/html'
      }
    }
}
