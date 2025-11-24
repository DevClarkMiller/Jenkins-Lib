def call(String imageName, String command) {
    sh "docker run -it --rm -v '${PWD}:/workspace' -w /workspace ${imageName} && ${command}"
}
