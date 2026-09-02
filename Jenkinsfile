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
        dir('jenkinpipelnedemo') {
            withEnv(['DOCKER_HOST=tcp://localhost:2375']) {
                bat 'docker build -t springboot-app .'
                
                // 1. Create a shared network (ignore error if it already exists)
                bat 'docker network create app-net || exit 0'
                
                // 2. Cleanup existing containers
                bat 'docker rm -f mysql-db springboot-app-container || exit 0'
                
                // 3. Start MySQL container attached to the network with alias "mysql-db"
                bat 'docker run -d --name mysql-db --network app-net -e MYSQL_ROOT_PASSWORD=rootpassword -e MYSQL_DATABASE=your_database_name mysql:8.0'
                
                // 4. Run Spring Boot container on the same network
                bat 'docker run -d --name springboot-app-container --network app-net -p 8080:8080 springboot-app'
            }
        }
    }
}
    }

    post {
        success { echo 'Pipeline completed successfully!' }
        failure { echo 'Pipeline failed!' }
    }
}
