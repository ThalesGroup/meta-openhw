do_deploy() {
    install -m 755 ${D}/share/opensbi/*/${RISCV_SBI_PLAT}/firmware/fw_payload.* ${DEPLOYDIR}/
}

EXTRA_OEMAKE:append:cv32a6-genesys2 = " PLATFORM_RISCV_ISA=rv32ima PLATFORM_RISCV_XLEN=32"
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-rename-ariane-to-cva6.patch \
            file://0001-Reverting-Makefile-Don-t-specify-mabi-or-march.patch \
            "
