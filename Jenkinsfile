pipeline {
    agent {
      kubernetes {
        label 'ui-test'
      }
    }
    tools {
        maven 'apache-maven-3.5.4'
        jdk 'oracle-jdk8-latest'
    }
    stages {
        stage('Build') {
            steps {
                wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
                  sh 'mvn clean install javadoc:aggregate'
                }
                sh 'cd standalone/org.eclipse.epsilon.standalone/ && bash build-javadoc-jar.sh'
            }
        }
        stage('Update website') {
          sh 'echo rm -rf /home/data/httpd/download.eclipse.org/epsilon/interim && echo cp -r "$WORKSPACE/releng/org.eclipse.epsilon.updatesite.interim/target/site" /home/data/httpd/download.eclipse.org/epsilon/interim'
          sh 'echo rm -rf /home/data/httpd/download.eclipse.org/epsilon/interim/site.zip && echo cp "$WORKSPACE/releng/org.eclipse.epsilon.updatesite.interim/target/site_assembly.zip" /home/data/httpd/download.eclipse.org/epsilon/interim/site.zip'
          sh 'echo rm -rf /home/data/httpd/download.eclipse.org/epsilon/interim-jars/* && echo cp $WORKSPACE/standalone/org.eclipse.epsilon.standalone/target/epsilon-* /home/data/httpd/download.eclipse.org/epsilon/interim-jars'
          sh 'echo rm -rf /home/data/httpd/download.eclipse.org/epsilon/interim-javadoc && echo cp -r "$WORKSPACE/target/site/apidocs" /home/data/httpd/download.eclipse.org/epsilon/interim-javadoc'
        }
        stage('Deploy to OSSRH') {
          withMaven(maven: 'apache-maven-3.3.9', mavenSettingsFilePath: '/opt/public/hipp/homes/genie.epsilon/.m2/settings-deploy-ossrh.xml') {
            sh 'mvn -f standalone/org.eclipse.epsilon.standalone/pom.xml -P ossrh org.eclipse.epsilon:eutils-maven-plugin:deploy'
          }
        }
    }
}
