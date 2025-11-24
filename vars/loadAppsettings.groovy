def call(String projectName, String environment, String envFileName = null) {
    String finalName = envFileName ?: "appsettings.${environment}.json"
    withCredentials([file(credentialsId: "${projectName}.${finalName}", variable: 'APP_SETTINGS_FILE')]) {
        String secretContent = readFile(env.APP_SETTINGS_FILE)
        writeFile file: finalName, text: secretContent
    }
}
