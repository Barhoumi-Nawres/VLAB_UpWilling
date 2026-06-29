DESCRIPTION = "Develop image linux for raspberrypi02w "
SUMMARY = "${DESCRIPTION}"
LICENSE = "CLOSED"


inherit core-image

#core-boot contains busybox ,and simple things..etc
IMAGE_INSTALL = " packagegroup-core-boot"

IMAGE_FEATURES = " allow-empty-password allow-root-login debug-tweaks ssh-server-openssh"
