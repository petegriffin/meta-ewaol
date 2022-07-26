# Copyright (c) 2021-2022, Arm Limited.
#
# SPDX-License-Identifier: MIT

SUMMARY = "Container engine integration tests."
DESCRIPTION = "Integration tests for the Docker container engine. \
               Tests may be run standalone via \
               run-container-engine-integration-tests, or via the ptest \
               framework using ptest-runner."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

OVERRIDES:append = "${EWAOL_OVERRIDES}"

TEST_FILES = "file://container-engine-integration-tests.bats \
              file://container-engine-funcs.sh"

TEST_FILES:append:ewaol-virtualization = " \
    file://container-engine-append-virtualization.bats \
    file://container-engine-virtualization-funcs.sh \
    "

TEST_FILES:append:ewaol-security = " \
    file://container-engine-append-security.bats \
    file://container-engine-security-funcs.sh \
    "

inherit runtime-integration-tests
require runtime-integration-tests.inc
