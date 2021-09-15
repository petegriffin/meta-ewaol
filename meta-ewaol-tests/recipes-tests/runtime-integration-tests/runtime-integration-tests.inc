# Copyright (c) 2021, Arm Limited.
#
# SPDX-License-Identifier: MIT

inherit ptest

RDEPENDS_${PN} += "bats"

# ptest aborts if it cannot find libgcc for pthread_cancel
RDEPENDS_${PN}-ptest += "libgcc"

TEST_DIR ?= "${datadir}/${BPN}"

do_install() {

    install -d "${D}/${TEST_DIR}"

    test_files=`echo ${TEST_FILES} | sed 's/file:\/\///g'`

    for test_file in ${test_files}; do
        install "${WORKDIR}/${test_file}" "${D}/${TEST_DIR}"
    done

    install -m 755 "${WORKDIR}/run-test-suite" "${D}/${TEST_DIR}/run-${TEST_SUITE_NAME}"
    sed -i "s#%TESTNAME%#${TEST_SUITE_NAME}#g" "${D}/${TEST_DIR}/run-${TEST_SUITE_NAME}"

}

do_install_ptest() {

    # Point the deployed run-ptest script to the test suite install directory
    # Use '#' as delimiter for sed as we are replacing with a path

    sed -i "s#%TESTDIR%#${TEST_DIR}#g" ${D}${PTEST_PATH}/run-ptest
    sed -i "s#%TESTNAME%#${TEST_SUITE_NAME}#g" ${D}${PTEST_PATH}/run-ptest

}