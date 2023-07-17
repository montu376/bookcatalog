pipeline{
    agent any
    stages{
        stage('Building Image and dockerzing it'){
            agent {
                label 'montuUbuntu'
            }
            steps {
                sh 'mvn package -DskipTests'
                sh 'docker build -t montud/book-catalog:latest .'
            }
        } 

        stage('docker push'){
            agent {
                label 'montuUbuntu'
            }
            steps {
                sh 'docker push montud/book-catalog:latest'
            }
        }


        stage('Kubernates deploy'){
            agent {
                label 'microkube'
            }
            steps {
               sh 'microk8s kubectl apply -f deploy.yml'
            }
        }
    }
    


}