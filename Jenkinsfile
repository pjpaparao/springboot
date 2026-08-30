pipeline {
    agent any

    tools {
        maven 'Maven_3.9'
        jdk 'JDK_17'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/pjpaparao/springboot.git'
            }
        }

        stage('Build') {
            steps {
                dir('jenkinpipelnedemo') {
                    bat 'mvn clean package'
                }
            }
        }

        stage('Test') {
            steps {
                dir('jenkinpipelnedemo') {
                    bat 'mvn test'
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying Spring Boot app...'
            }
        }
    }

    post {
        success { echo 'Pipeline completed successfully!' }
        failure { echo 'Pipeline failed!' }
    }
}
