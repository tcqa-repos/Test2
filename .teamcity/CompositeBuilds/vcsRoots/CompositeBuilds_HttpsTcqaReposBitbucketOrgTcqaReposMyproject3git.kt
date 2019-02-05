package CompositeBuilds.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.vcs.GitVcsRoot

object CompositeBuilds_HttpsTcqaReposBitbucketOrgTcqaReposMyproject3git : GitVcsRoot({
    uuid = "ab968391-9616-4a81-9d8c-3be88e20dbe1"
    name = "https://tcqa-repos@bitbucket.org/tcqa-repos/myproject3.git"
    url = "https://tcqa-repos@bitbucket.org/tcqa-repos/myproject3.git"
    authMethod = password {
        userName = "teamcity.qa.server@gmail.com"
        password = "credentialsJSON:e0cdab31-ab7d-4d5b-bc1c-575fabe440e3"
    }
})
