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
		    sh "pwd"
                    kubeconfigId: 'k8-config',
                    //enableConfigsubstituion: true
                    enableConfigSubstitution: true
                )
            }
        }
	}
}
