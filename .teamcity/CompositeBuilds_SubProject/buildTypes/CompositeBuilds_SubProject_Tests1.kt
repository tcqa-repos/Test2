package CompositeBuilds_SubProject.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_2.ideaRunner

object CompositeBuilds_SubProject_Tests1 : BuildType({
    name = "Tests 1"

    artifactRules = """
        **/* => artifact-%build.number%.zip
        **/* => artifact.zip
        -:teamcity => artifact.zip
        -:teamcity => artifact-%build.number%.zip
    """.trimIndent()

    vcs {
        root(AbsoluteId("HttpsGithubComTcqaReposCalculator"))
    }

    steps {
        script {
            scriptContent = """
                echo "##teamcity[testStarted name='pack.Test1' captureStandardOutput='false']"
                echo "##teamcity[testFinished name='pack.Test1' duration='138']"
                echo "##teamcity[testStarted name='pack.Test2' captureStandardOutput='false']"
                echo "##teamcity[testFinished name='pack.Test2' duration='128']"
                echo "##teamcity[testStarted name='pack.Test3' captureStandardOutput='false']"
                echo "##teamcity[testFinished name='pack.Test3' duration='148']"
                echo "##teamcity[testStarted name='pack1.Test3' captureStandardOutput='false']"
                echo "##teamcity[testFinished name='pack1.Test3' duration='400']"
            """.trimIndent()
        }
        ideaRunner {
            pathToProject = ""
            jdk {
                name = "1.7"
                path = "%env.JDK_18%"
                patterns("jre/lib/*.jar", "jre/lib/ext/jfxrt.jar")
                extAnnotationPatterns("%teamcity.tool.idea%/lib/jdkAnnotations.jar")
            }
            jvmArgs = "-Xmx256m"
            runConfigurations = """
                Main
                Tests
                Tests2
                Tests with spaces
            """.trimIndent()
            param("teamcity.coverage.idea.includePatterns", "pack.*")
            param("teamcity.coverage.runner", "IDEA")
        }
    }
})
