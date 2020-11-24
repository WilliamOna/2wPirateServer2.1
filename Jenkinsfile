pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
        stage('make file'){
            steps {
                sh 'touch ~/jenkins-was-here.txt'
            }
        }
    }
}
