# Copyright (c) 2021-2022, Arm Limited.
#
# SPDX-License-Identifier: MIT

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

QUIET_PRINTK = "20-quiet-printk.conf"

SRC_URI:append = "file://${QUIET_PRINTK}"

do_install:append() {
    install -Dm 0640 ${WORKDIR}/${QUIET_PRINTK} \
        ${D}${sysconfdir}/sysctl.d/${QUIET_PRINTK}
}
