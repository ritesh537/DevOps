pipelineJob("gitcheckout"){
    description('copy-git-repo')
    parameters{
        choiceParam('gitUrl',['https://github.com/ritesh537/ml-project'], 'Git Repo')
        choiceParam('gitBranch', ['main', 'feature'], 'Branch')

    }
    definition{
        cps{
            script(readFileFromWorkspace('DevOps/jenkins/pipelines/checkoutgit.groovy'))
            sandbox()
        }
    }
}
