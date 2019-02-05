package CompositeBuilds_MyProject_SubProjectA

import CompositeBuilds_MyProject_SubProjectA.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.Project

object Project : Project({
    id("CompositeBuilds_MyProject_SubProjectA")
    parentId("CompositeBuilds_MyProject")
    name = "SubProject A"

    buildType(CompositeBuilds_MyProject_SubProjectA_TestsFromTestsSubproject)
    buildType(CompositeBuilds_MyProject_SubProjectA_RunAllTestsInSuitesSubproject)
    buildType(CompositeBuilds_MyProject_SubProjectA_TestsFromCalculatorSubproject)
    buildType(CompositeBuilds_MyProject_SubProjectA_TestsFromCalculatorSubprojectIntelliJ20172)
})
