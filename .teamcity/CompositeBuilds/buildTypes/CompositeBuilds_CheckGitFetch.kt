package CompositeBuilds.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*

object CompositeBuilds_CheckGitFetch : BuildType({
    name = "Check git fetch"

    vcs {
        root(CompositeBuilds.vcsRoots.CompositeBuilds_HttpsTcqaReposBitbucketOrgTcqaReposMyproject3git)

        checkoutMode = CheckoutMode.ON_SERVER
    }
})
