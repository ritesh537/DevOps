pipelineJob("gitcheckout"){
    description('copy-git-repo')
    parameters{
        choiceParam('gitUrl',['https://github.com/ritesh537/ml-project'], 'Git Repo')
        choiceParam('gitBranch', ['master', 'feature'], 'Branch')

    }
    definition{
        cps{
            script(readFileFromWorkspace('jenkins/pipelines/checkoutgit.groovy'))
            sandbox()
        }
    }
}
