properties([parameters([choice(choices: ['master', 'branch-1', 'branch-2'], description: 'Select branch to build image', name: 'branch')])])
node {
    def app

    stage('Clone repository') {
        /* Cloning the Repository to our Workspace */
	    echo "Pulling changes from the branch ${params.branch}"
        checkout scm
    }

    stage('Build image') {
        /* This builds the actual image */

        app = docker.build("798167/branch-2-image")
    }


    stage('Push image') {
        /* 
			You would need to first register with DockerHub before you can push images to your account
		*/
        docker.withRegistry('https://registry.hub.docker.com', 'dockerHub') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
            } 
                echo "Trying to Push Docker Build to DockerHub"
    }
}
