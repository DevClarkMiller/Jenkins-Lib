def call(String imageName, String command) {
	def cmd = command.collect { "\"${it}\"" }.join(" ")
    sh """
        docker run --rm -v "\$WORKSPACE:/workspace" -w /workspace ${image} bash -c ${cmd}
    """
}
