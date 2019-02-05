package CompositeBuilds_MyProject_SubProjectB.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.gradle

object CompositeBuilds_MyProject_SubProjectB_RunAllTestsInSuitesSubproject : BuildType({
    name = "Run all tests in suites subproject"

    vcs {
        root(CompositeBuilds_MyProject.vcsRoots.CompositeBuilds_MyProject_HttpsGithubComTcqaReposGradleRefsHeadsMaster)
    }

    steps {
        gradle {
            tasks = "clean :suites:build"
            buildFile = ""
        }
    }
})
