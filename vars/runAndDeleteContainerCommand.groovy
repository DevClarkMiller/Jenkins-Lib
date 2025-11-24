def call(String imageName, String command) {
	echo command
    sh "docker run --rm -v '${PWD}:/workspace' -w /workspace ${imageName} bash -c "${command.replaceAll('\\$', '\\\\\\$')}" """
}
