package CompositeBuilds_MyProject.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.ant
import jetbrains.buildServer.configs.kotlin.v2018_2.ideaDuplicates
import jetbrains.buildServer.configs.kotlin.v2018_2.ideaRunner
import jetbrains.buildServer.configs.kotlin.v2018_2.triggers.vcs

object CompositeBuilds_MyProject_BuildWithDuplicates : BuildType({
    name = "Build with duplicates"

    vcs {
        root(CompositeBuilds_MyProject.vcsRoots.CompositeBuilds_MyProject_HttpsGithubComTcqaReposCalculator)

        checkoutMode = CheckoutMode.ON_SERVER
    }

    steps {
        ideaRunner {
            pathToProject = ""
            jdk {
                name = "1.7"
                path = "%env.JDK_17%"
                patterns("jre/lib/*.jar", "jre/lib/ext/jfxrt.jar")
                extAnnotationPatterns("%teamcity.tool.idea%/lib/jdkAnnotations.jar")
            }
            jvmArgs = "-Xmx256m"
            runConfigurations = "Tests"
        }
        ant {
            enabled = false
            mode = antFile {
                path = "junittest.xml"
            }
            targets = "all"
        }
        ideaDuplicates {
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            pathToProject = ""
            jdk {
                name = "1.7"
                path = "%env.JDK_18%"
                patterns("jre/lib/*.jar", "jre/lib/ext/jfxrt.jar")
                extAnnotationPatterns("%teamcity.tool.idea%/lib/jdkAnnotations.jar")
            }
            jvmArgs = "-Xmx1G -XX:ReservedCodeCacheSize=240m"
            targetJdkHome = "%env.JDK_18%"
            lowerBound = 1
            discardCost = 0
            distinguishMethods = true
            distinguishTypes = true
            distinguishLiterals = true
            extractSubexpressions = true
            includeTestSources = true
        }
    }

    triggers {
        vcs {
        }
    }
})
