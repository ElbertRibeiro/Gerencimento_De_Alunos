from distutils.core import setup

setup(
   name='Distutils',
   version='1.0',
   description='A useful module',
   author='Elbert Ribeiro',
   author_email='elbertprofissional@gmail.com',
   package = ['distutils', 'distutils.command'],
   package_dir = {'': 'app/packages'}
)