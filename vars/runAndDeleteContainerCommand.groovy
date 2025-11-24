def call(String imageName, String command) {
    sh "docker run --rm -v '${PWD}:/workspace' -w /workspace ${imageName} '${command}'"
}
