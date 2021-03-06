package CompositeBuilds_MyProject_SubProjectB.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.v2018_2.ideaDuplicates
import jetbrains.buildServer.configs.kotlin.v2018_2.ideaInspections

object CompositeBuilds_MyProject_SubProjectB_TestsFromTestsSubproject : BuildType({
    name = "Tests from tests subproject"

    vcs {
        root(CompositeBuilds_MyProject.vcsRoots.CompositeBuilds_MyProject_HttpsGithubComTcqaReposGradleRefsHeadsMaster)

        checkoutMode = CheckoutMode.ON_SERVER
    }

    steps {
        gradle {
            tasks = "clean :tests:test"
            buildFile = ""
            coverageEngine = idea {
                includeClasses = "*Test"
            }
        }
        ideaInspections {
            pathToProject = "build.gradle"
            jvmArgs = "-Xmx512m -XX:ReservedCodeCacheSize=240m"
            targetJdkHome = "%env.JDK_18%"
        }
        ideaDuplicates {
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            pathToProject = "build.gradle"
            jvmArgs = "-Xmx1G -XX:ReservedCodeCacheSize=240m"
            targetJdkHome = "%env.JDK_18%"
            lowerBound = 10
            discardCost = 0
            distinguishMethods = true
            distinguishTypes = true
            distinguishLiterals = true
            extractSubexpressions = true
        }
    }
})
