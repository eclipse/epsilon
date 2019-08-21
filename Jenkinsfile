pipeline {
    agent {
      kubernetes {
        label 'ui-test'
      }
    }
    tools {
        maven 'apache-maven-3.6.0'
        jdk 'oracle-jdk8-latest'
    }
    stages {
        stage('Build') {
            steps {
                wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
		    sh 'mvn clean install javadoc:aggregate'
		}
            }
        }
    }
}
