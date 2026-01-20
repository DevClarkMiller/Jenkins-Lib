def call(Map config) {
    pipeline {
        agent any
        parameters {
            booleanParam(name: 'All', defaultValue: false, description: 'Run all')
            booleanParam(name: 'Dev', defaultValue: false, description: 'Run dev')
            booleanParam(name: 'Prod', defaultValue: false, description: 'Run prod')
        }
        stages {
            stage('Determine Changes and run pipelines') {
                steps {
                    script {
                        def toTrigger = []
                        config.pipelines.each { service, path ->
                            if (params.All || checkMicroservice(path)) {
                                toTrigger << service
                            }
                        }
                        toTrigger.each { service ->
                            build job: service, parameters: [
                                booleanParam(name: 'All', value: params.All),
                                booleanParam(name: 'Dev', value: params.Dev),
                                booleanParam(name: 'Prod', value: params.Prod)
                            ], wait: false
                        }
                    }
                }
            }
        }
    }
}