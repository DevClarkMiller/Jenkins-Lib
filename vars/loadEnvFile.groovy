def call(String projectName, String projectTier, String environment, String fileName) {
    withCredentials([file(credentialsId: "${projectName}-${projectTier}-${environment}-env", variable: 'ENV_FILE')]) {
        def secretContent = readFile(env.ENV_FILE)
        writeFile file: fileName, text: secretContent
    }
}
