# Based on: gator-daemon_7.7.0.bb
# In open-source project: https://git.yoctoproject.org/git/meta-arm
#
# Original file: Copyright (c) 2021 Clément Péron <peron.clem@gmail.com>
# Modifications: Copyright (c) 2021 Arm Limited and Contributors. All rights reserved.
#
# SPDX-License-Identifier: GPLv2 & LGPLv2.1+ & Apache-2.0

SUMMARY = "DS-5 Streamline Gator daemon"
DESCRIPTION = "Target-side daemon gathering data for ARM Streamline \
               Performance Analyzer."
HOMEPAGE = "https://github.com/ARM-software/gator"

# Note that Gator uses the Linux Perf API for
# most of its data collection. Check that your Kernel follow the
# configuration requirement specified here:
# https://github.com/ARM-software/gator#kernel-configuration

LICENSE = "GPLv2 & LGPLv2.1+ & Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://libsensors/COPYING.LGPL;md5=4fbd65380cdd255951079008b364516c \
                    file://mxml/LICENSE;md5=86d3f3a95c324c9479bd8986968f4327 \
                    file://k/perf_event.h;endline=14;md5=e548bf30a60b2ed11ef2dcf7bfdac230 \
                   "

SRCREV = "9d8d75fa08352470c51abc23fe3b314879bd8b78"
SRC_URI = "git://github.com/ARM-software/gator.git;protocol=http;branch=main \
           file://0001-Sources.mk-Remove-xml-PmuXMLParser.h-header-from-GAT.patch;striplevel=2 \
          "

S = "${WORKDIR}/git/daemon"

COMPATIBLE_HOST = "aarch64.*-linux"

EXTRA_OEMAKE = "'CFLAGS=${CFLAGS} ${TARGET_CC_ARCH} -D_DEFAULT_SOURCE -DETCDIR=\"${sysconfdir}\"' \
                'LDFLAGS=${LDFLAGS} ${TARGET_CC_ARCH}' 'CROSS_COMPILE=${TARGET_PREFIX}' \
                'CXXFLAGS=${CXXFLAGS} ${TARGET_CC_ARCH} -fno-rtti' CC='${CC}' CXX='${CXX}' V=1"

do_install() {
        install -d ${D}${sbindir}
        install -m 0755 ${S}/gatord ${D}${sbindir}/gatord
}
