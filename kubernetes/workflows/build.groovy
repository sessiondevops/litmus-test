pipeline{
	agent any
	stages
	{
	stage('Checkout Source') {
      steps {
        git url:'https://github.com/sessiondevops/litmus-test.git', branch:'main'
      }
    }
	stage('Deploy App') {
      steps {
        script {
          kubernetesDeploy(configs: "kubernetes/workflows/pod-delete1.yaml", kubeconfigId: "k8-config")
        }
      }
    }
}
}
