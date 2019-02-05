package CompositeBuilds_MySimpleProject_NewSubProject

import CompositeBuilds_MySimpleProject_NewSubProject.buildTypes.*
import CompositeBuilds_MySimpleProject_NewSubProject.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project

object Project : Project({
    id("CompositeBuilds_MySimpleProject_NewSubProject")
    parentId("CompositeBuilds_MySimpleProject")
    name = "New SubProject"

    vcsRoot(CompositeBuilds_MySimpleProject_NewSubProject_HttpsGithubComJuliaReshMyProject)

    buildType(CompositeBuilds_MySimpleProject_NewSubProject_Tests21)
    buildType(CompositeBuilds_MySimpleProject_NewSubProject_Tests2)
})
