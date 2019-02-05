package CompositeBuilds_MyProject_SubProjectA.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.v2018_2.ideaDuplicates
import jetbrains.buildServer.configs.kotlin.v2018_2.ideaInspections

object CompositeBuilds_MyProject_SubProjectA_TestsFromCalculatorSubproject : BuildType({
    name = "Tests from Calculator subproject"

    artifactRules = """
        **/* => artifact.zip
        %system.teamcity.build.tempDir%/inspection*result/** => inspections-reports-data-%build.number%.zip
        %system.teamcity.build.tempDir%/idea-logs/** => inspections-reports-idea-logs-%build.number%.zip
    """.trimIndent()

    params {
        param("system.teamcity.dont.delete.temp.result.dir", "true")
    }

    vcs {
        root(CompositeBuilds_MyProject.vcsRoots.CompositeBuilds_MyProject_HttpsGithubComTcqaReposGradleRefsHeadsMaster)
    }

    steps {
        gradle {
            tasks = "clean :Calculator:build"
            buildFile = ""
            coverageEngine = idea {
                includeClasses = "myPackage.*"
            }
        }
        gradle {
            name = "New build step"
            enabled = false
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            tasks = "clean :Calculator:build"
            buildFile = ""
        }
        step {
            type = "SleepNSeconds"
            enabled = false
            param("timeout-in-seconds", "6000")
        }
        ideaInspections {
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            pathToProject = "build.gradle"
            jvmArgs = "-Xmx512m -XX:ReservedCodeCacheSize=240m"
            targetJdkHome = "%env.JDK_18%"
            includeExcludePatterns = """
                +:src/**
                -:*/build/**
            """.trimIndent()
        }
        ideaDuplicates {
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            pathToProject = "build.gradle"
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

    failureConditions {
        testFailure = false
        nonZeroExitCode = false
    }
})
