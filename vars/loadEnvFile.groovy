def call(String projectName, String projectTier, String environment) {
    withCredentials([file(credentialsId: "${projectName}-${projectTier}-${environment}-env", variable: 'ENV_FILE')]) {
        def secretContent = readFile(env.ENV_FILE)
        writeFile file: ".env.${environment}", text: secretContent
    }
}
