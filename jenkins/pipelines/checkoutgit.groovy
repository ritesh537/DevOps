node{
stage('copy-git-repo'){
    deleteDir()
    checkout([
        $class: 'GitSCM',
        branches:[[name: gitBranch]],
        doGenerateSubmoduleConfigurations:false,
        userRemoteConfigs:[[url: gitUrl]]
    ])
}
}
