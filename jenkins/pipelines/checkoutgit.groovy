Node{
stage('copy-git-repo'){
    deleteDir()
    checkout([
        $class: 'gitSCM',
        branches:[[name: ${gitBranch}]],
        doGenerateSubmoduleConfiguration:false
        userRemoteConfigs:[[url: ${gitUrl}]]
    ])
}
}