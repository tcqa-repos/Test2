package CompositeBuilds_MyProject_SubProjectA.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.v2018_2.ideaInspections

object CompositeBuilds_MyProject_SubProjectA_RunAllTestsInSuitesSubproject : BuildType({
    name = "Run all tests in suites subproject"

    artifactRules = "teamcity-issue => artifact.zip"

    vcs {
        root(CompositeBuilds_MyProject.vcsRoots.CompositeBuilds_MyProject_HttpsGithubComTcqaReposGradleRefsHeadsMaster)
    }

    steps {
        gradle {
            tasks = "clean :suites:build"
            buildFile = ""
        }
        ideaInspections {
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            pathToProject = "build.gradle"
            jvmArgs = "-Xmx512m -XX:ReservedCodeCacheSize=240m"
            targetJdkHome = "%env.JDK_18%"
        }
    }

    failureConditions {
        testFailure = false
        nonZeroExitCode = false
    }
})
