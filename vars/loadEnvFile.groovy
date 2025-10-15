def call(String projectName, String projectTier, String environment, String envFileName = null) {
    String finalEnvFileName = envFileName ?: ".env.${environment}"
    withCredentials([file(credentialsId: "${projectName}-${projectTier}-${environment}-env", variable: 'ENV_FILE')]) {
        String secretContent = readFile(env.ENV_FILE)
        writeFile file: finalEnvFileName, text: secretContent
    }
}
