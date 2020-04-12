from setuptools import setup

setup(
   name='packages',
   version='1.0',
   description='A useful module',
   author='Elbert Ribeiro',
   author_email='elbertprofissional@gmail.com',
   package = ['distutils', 'distutils.command'],
   package_dir = {'': 'app/packages'},
   python_requires='>=3',
   install_requires=['sqlite3', 'wxPython'],
)