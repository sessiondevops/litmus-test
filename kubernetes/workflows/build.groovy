pipeline{
	agent any
	stages
	{
	stage('Deploy App') {
      steps {
        script {
          kubernetesDeploy(configs: "pod-kill.yaml", kubeconfigId: "k8-config")
        }
      }
    }
}
}
