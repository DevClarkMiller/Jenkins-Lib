def call(String projectName, String projectTier, String environment, String envFileName = "") {
    String finalEnvFileName
    if (envFileName == "") {
        finalEnvFileName = ".env.${environment}"
    } else {
        finalEnvFileName = envFileName
    }
    withCredentials([file(credentialsId: "${projectName}-${projectTier}-${environment}-env", variable: 'ENV_FILE')]) {
        def secretContent = readFile(env.ENV_FILE)
        writeFile file: finalEnvFileName, text: secretContent
    }
}
