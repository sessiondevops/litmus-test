pipeline{
	agent any
	stages
	{
		stage("checkout")
		{
			checkout(scm)
		}
		stage("K8 Nodes"){
			steps{
				kubernetesDeploy(
					kubeconfigId: 'k8-config',
					//enableConfigsubstituion: true
					enableConfigSubstitution: true
					sh "kubectl get nodes"
				)
			}
		}
	}
}
