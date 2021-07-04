node{
stage('copy-git-repo'){
    deleteDir()
    checkout([
        $class: 'GitSCM',
        branches:[[name: gitBranch]],
        doGenerateSubmoduleConfigurations:false,
        extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: 'ml-project']],
        userRemoteConfigs:[[url: gitUrl]]
    ])
}
stage('uplod to artifactory'){
    sh ("tar -cvzf ml-project.tar.gz ml-project")
    def buildrepo = Artifactory.newServer url : 'http://13.52.79.180:8082/artifactory'
    buildrepo.credentialsId = 'artifactory'
   
    def uploadSpec = """{
    "files": [
    {
      "pattern" : "ml-project.tar.gz",
      "target" :"rks/"
     
    }
    ]
    }"""
     buildrepo.upload(uploadSpec)
}
}
