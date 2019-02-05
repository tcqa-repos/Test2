package CompositeBuilds_MyProject_SubProjectC.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.gradle

object CompositeBuilds_MyProject_SubProjectC_TestsFromTestsSubproject : BuildType({
    name = "Tests from tests subproject"

    vcs {
        root(CompositeBuilds_MyProject.vcsRoots.CompositeBuilds_MyProject_HttpsGithubComTcqaReposGradleRefsHeadsMaster)
    }

    steps {
        gradle {
            tasks = "clean :tests:test"
            buildFile = ""
        }
    }
})
