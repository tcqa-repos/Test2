package CompositeBuilds_MyProject_SubProjectC.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.gradle

object CompositeBuilds_MyProject_SubProjectC_CompileKotlin : BuildType({
    name = "Compile kotlin"

    vcs {
        root(CompositeBuilds_MyProject.vcsRoots.CompositeBuilds_MyProject_HttpsGithubComTcqaReposGradleRefsHeadsMaster)

        checkoutMode = CheckoutMode.ON_SERVER
    }

    steps {
        gradle {
            tasks = "clean :kotlin:build"
            buildFile = ""
        }
    }
})
