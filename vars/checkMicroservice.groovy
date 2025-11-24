def call(String microserviceFolder) {
	def changes = sh(
        script: "git diff --name-only HEAD~1 | grep '^${microserviceFolder}/' || true",
        returnStdout: true
    ).trim()

    if (!changes) {
        currentBuild.result = 'SUCCESS'
        return false // Indicates nothing changed
    }

    return true // Indicates there are changes
}