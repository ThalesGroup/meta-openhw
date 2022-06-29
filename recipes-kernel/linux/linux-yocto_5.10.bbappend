SRCREV_machine:cv64a6-genesys2 ?= "659361086d8b2ee2c8318f390029a350a6e7fb61"
SRCREV_machine:cv32a6-genesys2 ?= "659361086d8b2ee2c8318f390029a350a6e7fb61"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
FILESEXTRAPATHS:prepend:cv64a6-genesys2 := "${THISDIR}/${PN}/cv64a6:"
FILESEXTRAPATHS:prepend:cv32a6-genesys2 := "${THISDIR}/${PN}/cv32a6:"

SRC_URI += "file://defconfig \
            file://0001-Incorporate-lowrisc-drivers-for-latest-kernel-releas.patch \
            file://0005-Update-.gitignore.patch \
            file://0006-Add-Xilinx-emaclite.patch \
            file://0007-Update-for-linux-5.10.patch \
            file://0001-cva6-genesys2-add-32-and-64-bits-dts.patch \
           "

COMPATIBLE_MACHINE:append:cv64a6-genesys2 = "|cv64a6-genesys2"
COMPATIBLE_MACHINE:append:cv32a6-genesys2 = "|cv32a6-genesys2"
LINUX_VERSION:cv64a6-genesys2 = "5.10.7"
LINUX_VERSION:cv32a6-genesys2 = "5.10.7"
