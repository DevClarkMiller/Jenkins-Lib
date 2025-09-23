def call(String imageName, String script) {
    sh "docker run --rm -i --entrypoint sh ${imageName} -c \"sh ${script}\""
}
