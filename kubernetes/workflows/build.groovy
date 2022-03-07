pipeline{
    agent any
	stages
    {
     stage("K8 Nodes"){
            steps{
                kubernetesDeploy(
                    sh "ls -ltr"
					sh "pwd"
                    kubeconfigId: 'k8-config',
                    //enableConfigsubstituion: true
                    enableConfigSubstitution: true
                )
            }
        }
	}
}
