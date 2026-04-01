pipeline {
    agent {
        docker {
            image 'maven:3.9.6-eclipse-temurin-17'
            reuseNode true
        }
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                withCredentials([string(credentialsId: 'api-key', variable: 'API_KEY')]) {
                    sh 'mvn test -Dgroups=api'
                    }
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/**', fingerprint: true
        }
    }
}